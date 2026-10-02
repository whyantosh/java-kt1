public class Main {

    public static double totalBonusBudget(Employee[] staff) {
        double total = 0;

        for (Employee item : staff) {
            total += item.calculateBonus();
        }

        return total;
    }

    public static void main(String[] args) {

        Employee[] staff = {
                new Employee("Иванов В.В.", "Разработчик", 100000),
                new Employee("Грачев Е.И.", "Тестировщик", 90000),
                new Manager("Пронин С.А.", "Менеджер", 125000, 5),
                new Manager("Смирнов А.А.", "Менеджер", 160000, 8)
        };

        for (Employee item : staff) {
            System.out.println(item);
            System.out.println("Премия: " + item.calculateBonus());
        }

        System.out.println();

        int managerCount = 0;

        for (Employee item : staff) {
            if (item instanceof Manager) {
                Manager manager = (Manager) item;
                managerCount++;

                System.out.println(
                        manager.getName()
                                + ", размер команды: "
                                + manager.getTeamSize()
                );
            }
        }

        System.out.println("Количество менеджеров: " + managerCount);
        System.out.println("Всего сотрудников: " + Employee.getEmployeeCount());
        System.out.println("Общий бюджет на премии: " + totalBonusBudget(staff));
    }
    // В части Г instanceof не нужен, потому что используется полиморфизм.
    // Java сама вызывает нужную версию calculateBonus() в зависимости от реального типа объекта.
    // Поэтому для Employee вызывается метод Employee, а для Manager — переопределенный метод Manager.
}