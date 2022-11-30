public class Main {
    private static Employee[] employees = new Employee[10];
    public static void main(String[] args) {
        employees[0] = new Employee("Мельников Иван Владимирович", 4, 65_300);
        employees[1] = new Employee("Новгородова Ирина Александровна", 2, 62_700);
        employees[2] = new Employee("Васильева Анна Дмитриевна", 1, 58_900);
        employees[3] = new Employee("Померанцев Дмитрий Олегович", 1, 66_800);
        employees[4] = new Employee("Красников Евгений Алексеевич", 2, 67_300);
        employees[5] = new Employee("Жданова Инна Валерьевна", 5, 59_400);
        employees[6] = new Employee("Комаров Юрий Дмитриевич", 4, 63_500);
        employees[7] = new Employee("Тарасов Вячеслав Евгеньевич", 3, 58_200);
        employees[8] = new Employee("Ковалёв Олег Константинович", 5, 64_300);
        employees[9] = new Employee("Миронова Татьяна Анатольевна", 3, 68_500);
        printEmployeesInformation();
        int totalSalaryExpenses = calculateSalaryExpenses();
        System.out.println("Сумма затрат на зарплаты в месяц составляет " + totalSalaryExpenses + " рублей.");
        Employee minSalaryEmployee = defineMinSalary();
        System.out.println("Сотрудник с минимальной зарплатой: " + minSalaryEmployee);
        Employee maxSalaryEmployee = defineMaxSalary();
        System.out.println("Сотрудник с максимальной зарплатой: " + maxSalaryEmployee);
        double averageSalary = defineAverageSalary();
        System.out.println("Средняя зарплата - " + averageSalary + " рублей.");
        printEmployeesNames();
        int salaryRaise = 12;
        raiseSalary(salaryRaise);
        int departmentNumber = 4;
        Employee departmentMinEmployee = defineDepartmentMinSalary(departmentNumber);
        System.out.println("Сотрудник с минимальной зарплатой в отделе - " + departmentMinEmployee);
        Employee departmentMaxEmployee = defineDepartmentMaxSalary(departmentNumber);
        System.out.println("Сотрудник с максимальной зарплатой в отделе - " + departmentMaxEmployee);
        int totalDepartmentSalaryExpenses = calculateDepartmentSalaryExpenses(departmentNumber);
        System.out.println("Сумма затрат на зарплаты по отделу " + departmentNumber + " составляет " + totalDepartmentSalaryExpenses + " рублей.");
        double averageDepartmentSalary = defineAverageDepartmentSalary(departmentNumber);
        System.out.println("Средняя зарплата по отделу " + departmentNumber + " - " + averageDepartmentSalary + " рублей.");
        int salaryRaise2 = 8;
        raiseDepartmentSalary(salaryRaise2, departmentNumber);
        printDepartmentEmployeesNames(departmentNumber);
        int randomNumber = 61_000;
        findLowerSalaries(randomNumber);
        int randomNumber2 = 63_000;
        findHigherSalaries(randomNumber2);
    }

    public static void printEmployeesInformation() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }
    public static int calculateSalaryExpenses() {
        int salaryExpenses = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                salaryExpenses = salaryExpenses + employee.getSalary();
            }
        }
        return salaryExpenses;
    }

    public static Employee defineMinSalary() {
        int minSalary = Integer.MAX_VALUE;
        Employee minSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee.getSalary() < minSalary && employee != null) {
                minSalary = employee.getSalary();
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }

    public static Employee defineMaxSalary() {
        int maxSalary = Integer.MIN_VALUE;
        Employee maxSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalary && employee != null) {
                maxSalary = employee.getSalary();
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
    }

    public static double defineAverageSalary() {
        int counter = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                counter++;
            }
        }
        if (counter != 0) {
            return (double) calculateSalaryExpenses() / counter;
        }
        return 0;
    }

    public static void printEmployeesNames() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getName());
            }
        }
    }

    public static void raiseSalary(int raise) {
        double newSalary;
        for (Employee employee : employees) {
            if (employee != null) {
                newSalary = employee.getSalary() + employee.getSalary() / 100 * raise;
                System.out.println("После повышения зарплата сотрудника " + employee.getName() + " стала " + newSalary + " рублей.");
            }
        }
    }

    public static Employee defineDepartmentMinSalary(int department) {
        int departmentMinSalary = Integer.MAX_VALUE;
        Employee departmentMinSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee.getSalary() < departmentMinSalary && employee != null && employee.getDepartment() == department) {
                departmentMinSalary = employee.getSalary();
                departmentMinSalaryEmployee = employee;
            }
        }
        return departmentMinSalaryEmployee;
    }

    public static Employee defineDepartmentMaxSalary(int department) {
        int departmentMaxSalary = Integer.MIN_VALUE;
        Employee departmentMaxSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee.getSalary() > departmentMaxSalary && employee != null && employee.getDepartment() == department) {
                departmentMaxSalary = employee.getSalary();
                departmentMaxSalaryEmployee = employee;
            }
        }
        return departmentMaxSalaryEmployee;
    }

    public static int calculateDepartmentSalaryExpenses(int department) {
        int salaryExpenses = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                salaryExpenses = salaryExpenses + employee.getSalary();
            }
        }
        return salaryExpenses;
    }

    public static double defineAverageDepartmentSalary(int department) {
        int counter = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                counter++;
            }
        }
        if (counter != 0) {
            return (double) calculateDepartmentSalaryExpenses(department) / counter;
        }
        return 0;
    }

    public static void raiseDepartmentSalary(int raise, int department) {
        double newSalary;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                newSalary = employee.getSalary() + employee.getSalary() / 100 * raise;
                System.out.println("После повышения в отделе зарплата сотрудника " + employee.getName() + " стала " + newSalary + " рублей.");
            }
        }
    }

    public static void printDepartmentEmployeesNames(int department) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println("Ф.И.О.: " + employee.getName() + ", id: " + employee.getId() + ", зарплата " + employee.getSalary());
            }
        }
    }

    public static void findLowerSalaries(int number) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < number) {
                System.out.println("У сотрудника " + employee.getName() + " с id " + employee.getId() + " зарплата " + employee.getSalary() + " рублей меньше " + number);
            }
        }
    }

    public static void findHigherSalaries(int number) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > number) {
                System.out.println("У сотрудника " + employee.getName() + " с id " + employee.getId() + " зарплата " + employee.getSalary() + " рублей больше " + number);
            }
        }
    }
}