package study.hard.jjzhu.effectivejava;

// Two attacks on the internals of an "immutable" period

import java.util.*;

public class RepairedAttack {
    public static void main(String[] args) {
        // Attack the internals of a Period instance - Page 185
    	{ Date start = new Date();
        Date end = new Date();
        RepairedPeriod p = new RepairedPeriod(start, end);
        System.out.println("before attack1: "+p);

        end.setYear(78);  // Modifies internals of p!
        System.out.println("after attack1: "+p);
    	}

        {
            // Second attack on the internals of a Period instance - Page 186
            Date start = new Date();
            Date end = new Date();
            RepairedPeriod p = new RepairedPeriod(start, end);
            System.out.println("before attack2: "+p);

            p.end().setYear(78);  // Modifies internals of p!
            System.out.println("after attack2: "+p);
        }
    }

    static final class RepairedPeriod {
        private final Date start;
        private final Date end;

        /**
         * @param  start the beginning of the period
         * @param  end the end of the period; must not precede start
         * @throws IllegalArgumentException if start is after end
         * @throws NullPointerException if start or end is null
         */

//         Repaired constructor - makes defensive copies of parameters - Page 185
//         Stops first attack
      public RepairedPeriod(Date start, Date end) {
          this.start = new Date(start.getTime());
          this.end   = new Date(end.getTime());

          if (this.start.compareTo(this.end) > 0)
              throw new IllegalArgumentException(start +" after "+ end);
      }

//         Repaired accessors - make defensive copies of internal fields - Page 186
//         Stops second attack
      public Date start() {
          return new Date(start.getTime());
      }

      public Date end() {
          return new Date(end.getTime());
      }

        public String toString() {
            return start + " - " + end;
        }

        // Remainder omitted
    }
}



