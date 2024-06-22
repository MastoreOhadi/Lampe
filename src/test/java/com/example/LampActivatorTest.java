package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LampActivatorTest {

    @BeforeEach
    public void resetContext() {
        LampContext.resetInstance(); // Add a method to reset the singleton instance
    }

    // به ترتیب همه کلید ها فشار داده شود
    // اطمینان حاصل می کند که تمام لامپ ها به درستی روشن می شود
    @Test
    public void testAllKeysPressedInOrder() {
        List<Integer> keyPresses = List.of(1, 2, 3, 4, 5, 6, 7);
        int result = LampActivator.countLampActivations(keyPresses);
        assertEquals(7, result, "All lamps should be activated sequentially.");
    }

    // تست فشار دادن بعضی از کلیدها
    // اطمینان حاصل می کند تنها لامپ هایی که شرایط مورد نیاز را دارند روشن می شوند
    @Test
    public void testSomeKeysPressed() {
        List<Integer> keyPresses = List.of(1, 2, 3, 5, 6);
        int result = LampActivator.countLampActivations(keyPresses);
        assertEquals(3, result, "Only the first three lamps should be activated.");
    }

    //تست فشار ندادن هیچ کلید
    // اطمینان حاصل می کند که هیچ لامپی روشن نمی شود
    @Test
    public void testNoKeysPressed() {
        List<Integer> keyPresses = List.of();
        int result = LampActivator.countLampActivations(keyPresses);
        assertEquals(0, result, "No lamps should be activated.");
    }

    // تست فشار دادن کلیدها به صورت نامرتب
    // اطمینان حاصل می کند که تنها لامپ هایی که کلیدهای قبلی شان به ترتیب صحیح فشار داده شده روشن می شود
    @Test
    public void testKeysPressedOutOfOrder() {
        List<Integer> keyPresses = List.of(3, 1, 2, 4);
        int result = LampActivator.countLampActivations(keyPresses);
        assertEquals(3, result, "Only the lamp corresponding to the first key pressed should be activated.");
    }

    // تست فشار دادن کلید ها با تکرار
    // اطمینان حاصل می کنید که فشردن چند باره یک کلید تاثیری بر تعداد روشن شدن لامپ ها ندارد
    @Test
    public void testRepeatedKeyPresses() {
        List<Integer> keyPresses = List.of(1, 2, 2, 3, 4, 4, 4, 5);
        int result = LampActivator.countLampActivations(keyPresses);
        assertEquals(5, result, "Each lamp should only be activated once, regardless of repeated key presses.");
    }

    // تست فشار دادن کلید ها فراتر از محدوده
    // اطمینان حاصل می کند که کلیدهایی که شماره آنها خارج از محدوده(مثلا ۸ یا بالاتر) نادیده گرفته می شوند
    @Test
    public void testKeysBeyondRange() {
        List<Integer> keyPresses = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int result = LampActivator.countLampActivations(keyPresses);
        assertEquals(7, result, "Keys beyond the range should be ignored.");
    }

    // تست داده شده در توضیح
    // اطمینان حاصل می کند که طبق برنامه جواب خواسته شده را می دهد
    @Test
    public void tesAccordingToTheAssumptionOfTheProblem() {
        List<Integer> keyPresses = List.of(2, 1, 5, 4, 3, 7, 6);
        int result = LampActivator.countLampActivations(keyPresses);
        assertEquals(3, result, "According to the assumption of the problem, the lamps should be turned on 3 times.");
    }

}
