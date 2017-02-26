package com.hodor.ds.list.sll;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hodor.ds.list.exceptions.ElementNotFoundException;
import com.hodor.ds.list.exceptions.ListEmptyException;

/**
 * Unit test for SinglyLinkedList<T>
 */
public class SinglyLinkedListTest {

	private SinglyLinkedList<Integer> mySingleLinkedList;

	private static final String SIZE_MESSAGE = "The SLL size should be ";

	private static final String DELETE_MESSAGE = "The removed element must be ";

	private static final String CONTAINS_MESSAGE = "The element still is present in the list : ";

	@Before
	public void setUp() {
		mySingleLinkedList = new SinglyLinkedList<Integer>();
	}

	@Test
	public void testAddElementToSll() {
		mySingleLinkedList.add(20);
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 1), 1, mySingleLinkedList.size());
		mySingleLinkedList.add(30);
		mySingleLinkedList.add(40);
		mySingleLinkedList.add(25);
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 4), 4, mySingleLinkedList.size());

	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddElementAtToSll() {
		mySingleLinkedList.add(0, 10);
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 1), 1, mySingleLinkedList.size());
		mySingleLinkedList.add(1, 20);
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 2), 2, mySingleLinkedList.size());
		mySingleLinkedList.add(1, 30);
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 3), 3, mySingleLinkedList.size());
		mySingleLinkedList.add(3, 40);
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 4), 4, mySingleLinkedList.size());
		mySingleLinkedList.add(0, 5);
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 5), 5, mySingleLinkedList.size());
		mySingleLinkedList.add(3, 35);
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 6), 6, mySingleLinkedList.size());
		mySingleLinkedList.add(5, 38);
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 7), 7, mySingleLinkedList.size());
		mySingleLinkedList.add(8, 50);
		mySingleLinkedList.printList();
	}

	@Test(expected = ListEmptyException.class)
	public void testGetFirstElement() {
		mySingleLinkedList.add(10);
		mySingleLinkedList.add(20);
		Assert.assertEquals("The first element should be 10", new Integer(10), mySingleLinkedList.getFirst());
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 2), 2, mySingleLinkedList.size());
		mySingleLinkedList.printList();
		mySingleLinkedList.clear();
		Assert.assertEquals(getMessage(DELETE_MESSAGE, 10), new Integer(10), mySingleLinkedList.getFirst());
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 1), 1, mySingleLinkedList.size());
	}

	@Test
	public void testPrintSinglyLinkedList() {
		mySingleLinkedList.add(10);
		mySingleLinkedList.add(50);
		mySingleLinkedList.add(60);
		mySingleLinkedList.add(20);
		mySingleLinkedList.add(30);
		mySingleLinkedList.add(40);
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 6), 6, mySingleLinkedList.size());
		mySingleLinkedList.printList();
	}

	@Test
	public void testPrintSinglyLinkedListWhenListIsEmpty() {
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 0), 0, mySingleLinkedList.size());
		mySingleLinkedList.printList();
	}

	@Test(expected = ElementNotFoundException.class)
	public void testRemoveSpecifiedElement() {
		mySingleLinkedList.add(10);
		mySingleLinkedList.add(50);
		mySingleLinkedList.add(60);
		mySingleLinkedList.add(20);
		mySingleLinkedList.add(30);
		mySingleLinkedList.add(40);
		mySingleLinkedList.printList();
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 6), 6, mySingleLinkedList.size());
		boolean result = mySingleLinkedList.remove(new Integer(50));
		mySingleLinkedList.printList();
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 5), 5, mySingleLinkedList.size());
		Assert.assertTrue(getMessage(DELETE_MESSAGE, 50), result);
		Assert.assertFalse(getMessage(CONTAINS_MESSAGE, 50), mySingleLinkedList.contains(50));
		result = mySingleLinkedList.remove(new Integer(20));
		mySingleLinkedList.printList();
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 4), 4, mySingleLinkedList.size());
		Assert.assertTrue(getMessage(DELETE_MESSAGE, 20), result);
		Assert.assertFalse(getMessage(CONTAINS_MESSAGE, 20), mySingleLinkedList.contains(20));

		result = mySingleLinkedList.remove(new Integer(30));
		mySingleLinkedList.printList();
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 3), 3, mySingleLinkedList.size());
		Assert.assertTrue(getMessage(DELETE_MESSAGE, 30), result);
		Assert.assertFalse(getMessage(CONTAINS_MESSAGE, 30), mySingleLinkedList.contains(30));

		result = mySingleLinkedList.remove(new Integer(40));
		mySingleLinkedList.printList();
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 2), 2, mySingleLinkedList.size());
		Assert.assertTrue(getMessage(DELETE_MESSAGE, 40), result);
		Assert.assertFalse(getMessage(CONTAINS_MESSAGE, 40), mySingleLinkedList.contains(40));

		result = mySingleLinkedList.remove(new Integer(10));
		mySingleLinkedList.printList();
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 1), 1, mySingleLinkedList.size());
		Assert.assertTrue(getMessage(DELETE_MESSAGE, 10), result);
		Assert.assertFalse(getMessage(CONTAINS_MESSAGE, 10), mySingleLinkedList.contains(10));
		result = mySingleLinkedList.remove(new Integer(40));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveElementAt() {
		mySingleLinkedList.add(10);
		mySingleLinkedList.add(50);
		mySingleLinkedList.add(60);
		mySingleLinkedList.add(20);
		mySingleLinkedList.add(30);
		mySingleLinkedList.add(40);

		Assert.assertEquals(getMessage(SIZE_MESSAGE, 6), 6, mySingleLinkedList.size());
		mySingleLinkedList.printList();

		Integer result = mySingleLinkedList.remove(1);
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 5), 5, mySingleLinkedList.size());
		Assert.assertEquals(getMessage(DELETE_MESSAGE, 50), new Integer(50), result);
		Assert.assertFalse(getMessage(CONTAINS_MESSAGE, 50), mySingleLinkedList.contains(50));

		result = mySingleLinkedList.remove(0);
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 4), 4, mySingleLinkedList.size());
		Assert.assertEquals(getMessage(DELETE_MESSAGE, 10), new Integer(10), result);
		Assert.assertFalse(getMessage(CONTAINS_MESSAGE, 10), mySingleLinkedList.contains(10));

		result = mySingleLinkedList.remove(3);
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 3), 3, mySingleLinkedList.size());
		Assert.assertEquals(getMessage(DELETE_MESSAGE, 40), new Integer(40), result);
		Assert.assertFalse(getMessage(CONTAINS_MESSAGE, 40), mySingleLinkedList.contains(40));

		mySingleLinkedList.printList();
		result = mySingleLinkedList.remove(3);
	}

	@Test(expected = ListEmptyException.class)
	public void testRemoveFirstElement() {
		mySingleLinkedList.add(10);
		mySingleLinkedList.add(50);
		mySingleLinkedList.add(60);
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 3), 3, mySingleLinkedList.size());
		Integer result = mySingleLinkedList.removeFirst();
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 2), 2, mySingleLinkedList.size());
		Assert.assertEquals(getMessage(DELETE_MESSAGE, 10), new Integer(10), result);
		result = mySingleLinkedList.removeFirst();
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 1), 1, mySingleLinkedList.size());
		Assert.assertEquals(getMessage(DELETE_MESSAGE, 50), new Integer(50), result);
		mySingleLinkedList.printList();
		result = mySingleLinkedList.removeFirst();
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 0), 0, mySingleLinkedList.size());
		Assert.assertEquals(getMessage(DELETE_MESSAGE, 60), new Integer(60), result);
		System.out.println(mySingleLinkedList.isEmpty());
		Assert.assertTrue("The list should be empty", mySingleLinkedList.isEmpty());
		mySingleLinkedList.printList();
		mySingleLinkedList.removeFirst();
	}

	@Test(expected = ListEmptyException.class)
	public void testRemoveLastElement() {
		mySingleLinkedList.add(20);
		mySingleLinkedList.printList();
		Integer result = mySingleLinkedList.removeLast();
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 0), 0, mySingleLinkedList.size());
		Assert.assertEquals(getMessage(DELETE_MESSAGE, 20), new Integer(20), result);
		Assert.assertTrue("The list should be empty", mySingleLinkedList.isEmpty());
		mySingleLinkedList.printList();
		mySingleLinkedList.add(10);
		mySingleLinkedList.add(50);
		mySingleLinkedList.add(60);
		mySingleLinkedList.printList();
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 3), 3, mySingleLinkedList.size());
		result = mySingleLinkedList.removeLast();
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 2), 2, mySingleLinkedList.size());
		Assert.assertEquals(getMessage(DELETE_MESSAGE, 60), new Integer(60), result);
		mySingleLinkedList.printList();
		result = mySingleLinkedList.removeLast();
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 1), 1, mySingleLinkedList.size());
		Assert.assertEquals(getMessage(DELETE_MESSAGE, 50), new Integer(50), result);
		mySingleLinkedList.printList();
		result = mySingleLinkedList.removeLast();
		Assert.assertEquals(getMessage(SIZE_MESSAGE, 0), 0, mySingleLinkedList.size());
		Assert.assertEquals(getMessage(DELETE_MESSAGE, 10), new Integer(10), result);
		Assert.assertTrue("The list should be empty", mySingleLinkedList.isEmpty());
		mySingleLinkedList.printList();
		mySingleLinkedList.removeLast();
	}

	private String getMessage(String message, Object object) {
		return new StringBuilder().append(message).append(object).toString();
	}
}