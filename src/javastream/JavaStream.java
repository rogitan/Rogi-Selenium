package javastream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.testng.annotations.Test;

public class JavaStream {

	@Test
	public void regularCode() {

		ArrayList<String> names = new ArrayList<String>();
		names.add("Adam");
		names.add("Blue");
		names.add("Anna");
		names.add("Drake");
		names.add("Anthony");
		names.add("Aris");
		int count = 0;

		for (int i = 0; i < names.size(); i++) {

			String actualName = names.get(i);
			if (actualName.startsWith("A")) {
				count++;
			}

		}
		System.out.println(count);
	}

	@Test
	public void streamFilter() {

		ArrayList<String> names = new ArrayList<String>();
		names.add("Adam");
		names.add("Blu");
		names.add("Ana");
		names.add("Drake");
		names.add("Anthony");
		names.add("Aris");

		Long c = names.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(c);

		// convert the arraylist to stream // method // lambda expression // action
		names.stream().filter(n -> n.length() > 4).forEach(s -> System.out.println(s));

		names.stream().filter(n -> n.length() > 4).limit(1).forEach(n -> System.out.println(n));
	}

	@Test
	public void streamMap() {

		Stream.of("Ana", "Anthony", "Ada", "Drake", "Denz").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));
		
		//Converting List to ArrayList
		List<String> names = Arrays.asList("Ada", "Ana", "Anthony", "Drake", "Denz");
		
		//ArrayList to Stream -> Actions
		names.stream().filter(s -> s.startsWith("a")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

		//Converting List to ArrayList
		List<String> names2 = Arrays.asList("John", "Ivy", "Scott");

		// Merging two list into Stream
		Stream<String> newStream = Stream.concat(names.stream(), names2.stream());
//		newStream.sorted().forEach(s->System.out.println(s));

		boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Ada"));
		Assert.assertTrue(flag);

	}

	@Test
	public void streamCollect() {
		
		//Converting Stream to List
		List<String> li = Stream.of("Ana", "Anthony", "Ada", "Drake", "Denz").filter(s -> s.startsWith("A"))
				.collect(Collectors.toList());
		
		List<Integer> values = Arrays.asList(1,1,2,2,3,4,5,6);
		List<Integer> newValue = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(newValue);
		
	}
}
