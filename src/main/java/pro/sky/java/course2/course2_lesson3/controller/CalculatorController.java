package pro.sky.java.course2.course2_lesson3.controller;

        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.bind.annotation.RestController;
        import pro.sky.java.course2.course2_lesson3.servise.CalculatorService;

       

@RestController
@RequestMapping("/calculator")

public class CalculatorController {
    private final CalculatorService calculatorServise;

    public CalculatorController(CalculatorService calculatorServise) {

        this.calculatorServise = calculatorServise;
    }

    @GetMapping
    public String showGreetings() {
        return "Добро пожаловать в калькулятор!";
    }

    @GetMapping("/plus")
    public String sumNumbers(@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorServise.sum(num1, num2);
        return generateMessage(num1, num2, "+", result);

    }

    @GetMapping(name = "/plus", params = {"name1", "name2"})
    public String sumNumbers(@RequestParam int num1, @RequestParam int num2, @RequestParam int num3) {
        int result = calculatorServise.sum(num1, num2);
        return generateMessage(num1, num2, "+", result);
    }

    @GetMapping("/subtract")
    public String subtractNumbers(@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorServise.subtract(num1, num2);
        return generateMessage(num1, num2, "-", result);

    }

    @GetMapping("/multiply")
    public String multiplyNumbers(@RequestParam int num1, @RequestParam int num2) {
        int result = calculatorServise.multiply(num1, num2);
        return generateMessage(num1, num2, "*", result);

    }

    @GetMapping("/divide")
    public String divideNumbers(@RequestParam int num1, @RequestParam int num2) {

        if (num2 == 0) {
            return "Деление на 0 невозможно";
        }
        int result = calculatorServise.divide(num1, num2);
        return generateMessage(num1, num2, "/", result);
    }


    private String generateMessage(int num1, int num2, String action, int result) {
        return " " + num1 + action + num2 + " = " + result;
    }

}

