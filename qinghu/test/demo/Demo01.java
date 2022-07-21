package qinghu.test.demo;

import qinghu.test.common.Discount;
import qinghu.test.common.Fruits;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 1、有一家超市，出售苹果和草莓。其中苹果 8 元/斤，草莓 13 元/斤。
 * 现在顾客 A 在超市购买了若干斤苹果和草莓，需要计算一共多少钱？
 * 请编写函数，对于 A 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
 *
 * <p>
 * 2、超市增加了一种水果芒果，其定价为 20 元/斤。
 * 现在顾客 B 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
 * 请编写函数，对于 B 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
 *
 * <p>
 * 3、超市做促销活动，草莓限时打 8 折。
 * 现在顾客 C 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
 * 请编写函数，对于 C 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
 *
 * <p>
 * 4、促销活动效果明显，超市继续加大促销力度，购物满 100 减 10 块。
 * 现在顾客 D 在超市购买了若干斤苹果、 草莓和芒果，需计算一共需要多少钱？
 * 请编写函数，对于 C 购买的水果斤数 (水果斤数为大于等于 0 的整数)，计算并返回所购买商品的总价。
 */

public class Demo01 {

    public static void main(String[] args) {

        // 定义购物车集合
        List<BigDecimal> list = new ArrayList<>();

        while (true) {
            System.out.println("欢迎来到用户购买商品系统");
            System.out.println("1 购买苹果");
            System.out.println("2 购买草莓");
            System.out.println("3 购买芒果");
            System.out.println("4 结算购物车");
            System.out.println("5 退出");

            Scanner sc = new Scanner(System.in);
            System.out.println("请输入你的选择");
            String choose = sc.nextLine();

            switch (choose) {
                case "1":
                    add(choose, list);
                    break;
                case "2":
                    add(choose, list);
                    break;
                case "3":
                    add(choose, list);
                    break;
                case "4":
                    BigDecimal count = count(list);
                    System.out.println("购买水果的总价为：" + count);
                    break;
                case "5":
                    System.out.println("谢谢使用");
                    return;
                default:
                    System.out.println("输入的数据有误");
                    break;
            }
        }
    }

    /**
     * 购买水果的斤数
     */
    public static void add(String number, List<BigDecimal> list) {
        Scanner scanner = new Scanner(System.in);

        if ("1".equals(number)) {
            System.out.println("请输入购买苹果的斤数");

            double weight = scanner.nextDouble();

            if (weight < 0) {
                throw new RuntimeException("请输入正确的购买斤数");
            }

            list.add(BigDecimal.valueOf(Fruits.APPLE * weight));

            return;
        }

        if ("2".equals(number)) {
            System.out.println("请输入购买草莓的斤数");
            double weight = scanner.nextDouble();

            if (weight < 0) {
                throw new RuntimeException("请输入正确的购买斤数");
            }

            System.out.println("是否打折 1 是 2 否");

            if (scanner.nextInt() == 1) {
                list.add(BigDecimal.valueOf(Fruits.STRAWBERRY * weight * Discount.EIGHT_DISCOUNT));
            } else {
                list.add(BigDecimal.valueOf(Fruits.STRAWBERRY * weight));
            }

            return;
        }

        if ("3".equals(number)) {
            System.out.println("请输入购买芒果的斤数");

            double weight = scanner.nextDouble();

            if (weight < 0) {
                throw new RuntimeException("请输入正确的购买斤数");
            }

            list.add(BigDecimal.valueOf(Fruits.MANGO * weight));
        }
    }

    /**
     * 计算水果的总价
     */
    private static BigDecimal count(List<BigDecimal> list) {

        BigDecimal sum = new BigDecimal(0);

        for (BigDecimal bigDecimal : list) {
            sum = sum.add(bigDecimal);
        }

        if (sum.compareTo(new BigDecimal(100)) > -1) {
            sum = sum.subtract(new BigDecimal(10));
        }

        // 清空购物车
        list.clear();

        return sum;
    }
}
