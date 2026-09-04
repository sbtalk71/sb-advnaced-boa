package dataset;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Demo {

	public static void main(String[] args) {
		
		Runnable r=()->System.out.println("this is a thread");
		
		Consumer<String> consumer=s->System.out.println(s);
		
		Supplier<String> supplier=()->"hello";
		
		Function<String, String> f1=s->s.concat("Hello");

	}

}
