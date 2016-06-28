package nl.daanrosbergen.stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackUnitTest {
    Stack stack;
    @Before public void setUp() {
        stack = new ListStack();
    }

    @Test public void shouldPushItemToStack() throws Exception {
        stack.push("Een");
        Assert.assertEquals(stack.size(), 1);
    }

    @Test public void shouldPushItemsToStack() throws Exception {
        stack.push("Een");
        stack.push("Twee");
        stack.push("Drie");
        Assert.assertEquals(stack.size(), 3);
    }

    @Test public void shouldPopItemFromStack() throws Exception {
        stack.push("Een");
        Object poppedItem = stack.pop();
        Assert.assertEquals(stack.size(), 0);
        Assert.assertNotNull(poppedItem);
    }

    @Test public void shouldPopItemsFromStack() throws Exception {
        Object item1 = "Een";
        Object item2 = "Twee";
        Object item3 = "Drie";
        stack.push(item1);
        stack.push(item2);
        stack.push(item3);
        Assert.assertEquals(stack.size(), 3);
        Object poppedItem1 = stack.pop();
        Assert.assertNotNull(poppedItem1);
        Assert.assertEquals(poppedItem1, item3);
        Assert.assertEquals(stack.size(), 2);
        Object poppedItem2 = stack.pop();
        Assert.assertNotNull(poppedItem2);
        Assert.assertEquals(poppedItem2, item2);
        Assert.assertEquals(stack.size(), 1);
        Object poppedItem3 = stack.pop();
        Assert.assertNotNull(poppedItem3);
        Assert.assertEquals(poppedItem3, item1);
        Assert.assertEquals(stack.size(), 0);
    }

    @Test public void shouldBePeekable() throws Exception {
        Object item = "Een";
        stack.push(item);
        Assert.assertEquals(stack.peek(), item);
        Assert.assertEquals(stack.size(), 1);
    }

    @Test public void shouldHaveASize() throws Exception {
        Assert.assertEquals(stack.size(), 0);
        stack.push("Een");
        Assert.assertEquals(stack.size(), 1);
    }

    @Test public void shouldBeEmpty() throws Exception {
        Assert.assertEquals(stack.isEmpty(), true);
    }
}
