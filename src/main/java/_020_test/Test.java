package _020_test;

import java.time.LocalDateTime;
import java.util.concurrent.*;

/**
 * @author cct
 */
public class Test {

    static class DelayedElement implements Delayed {
        private final int value; // 数字值
        private final long triggerTime; // 触发时间，单位：毫秒

        public DelayedElement(int value, long delayInMillis) {
            this.value = value;
            this.triggerTime = System.currentTimeMillis() + delayInMillis;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(triggerTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed other) {
            if (other instanceof DelayedElement) {
                return Long.compare(this.triggerTime, ((DelayedElement) other).triggerTime);
            }
            return 0;
        }

        public int getValue() {
            return value;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayedElement> queue = new DelayQueue<>();
        System.out.println(LocalDateTime.now());
        queue.put(new DelayedElement(1, 1000));

        System.out.println(queue.take().value);
        System.out.println(LocalDateTime.now());


    }
}
