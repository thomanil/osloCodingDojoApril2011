package scotsman;

import org.junit.Test;

import static org.junit.Assert.*;


public class NodeTest {

	@Test
	public void testToString_single_node() {
		assertEquals("root\n", new Node("root").toString());
	}

	@Test
	public void testToString_one_child() {
		assertEquals(
				"root\n" +
				"\tchild\n"
				, new Node("root").withChild(new Node("child"))
				.toString());
	}

	@Test
	public void testToString_two_children() {
		assertEquals(
				"root\n" +
				"\tchild1\n" +
				"\tchild2\n"
				, new Node("root")
					.withChild(new Node("child1"))
					.withChild(new Node("child2"))
				.toString());
	}

	@Test
	public void testToString_granchild() {
		assertEquals(
				"root\n" +
				"\tchild\n" +
				"\t\tgrandchild\n"
				, new Node("root")
					.withChild(new Node("child")
						.withChild(new Node("grandchild")))
				.toString());
	}


}
