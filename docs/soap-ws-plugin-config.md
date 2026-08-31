## SOAP WebService Maven Plugin Configuration for Top down approach and Client code generation

```xml
<plugins>

            <!-- Generate Java classes from WSDL -->
            <plugin>
            <groupId>org.codehaus.mojo</groupId>
            <artifactId>jaxb2-maven-plugin</artifactId>
            <version>3.2.0</version>
            <executions>
                <execution>
                    <id>xjc</id>
                    <goals>
                        <goal>xjc</goal>
                    </goals>
                </execution>
            </executions>
            <configuration>
            <sourceType>wsdl</sourceType>
                <sources>
                    <source>${project.basedir}/src/main/resources/calculator.wsdl</source>
                </sources>
                <outputDirectory>${project.build.directory}/generated-sources/jaxb</outputDirectory>
                <clearOutputDir>false</clearOutputDir>
            </configuration>
        </plugin>
<plugin>
    <groupId>org.codehaus.mojo</groupId>
    <artifactId>build-helper-maven-plugin</artifactId>
    <version>3.5.0</version>
    <executions>
        <execution>
            <id>add-source</id>
            <phase>generate-sources</phase>
            <goals>
                <goal>add-source</goal>
            </goals>
            <configuration>
                <sources>
                    <!-- Match this path exactly with your jaxb2-maven-plugin outputDirectory -->
                    <source>${project.build.directory}/generated-sources/jaxb</source>
                </sources>
            </configuration>
        </execution>
    </executions>
</plugin>

        </plugins>
```