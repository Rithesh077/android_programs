def calculate(num1, num2, op):
    if op == '+':
        return num1 + num2
    elif op == '-':
        return num1 - num2
    elif op == '*':
        return num1 * num2
    elif op == '/':
        if num2 == 0:
            return "Error: Division by zero is not allowed."
        return num1 / num2
    else:
        return "Error: Invalid operator. Please use +, -, *, or /."


while True:
    try:
        num1 = float(input("Enter first number: "))
        num2 = float(input("Enter second number: "))
    except ValueError:
        print("Error: Invalid input. Please enter numeric values.")
    print("Main menu"
          "\n1. Addition (+)"
          "\n2. Subtraction (-)"
          "\n3. Multiplication (*)"
          "\n4. Division (/)"
          "\n5. Exit")
    choice = input("Choose an operation (1-5): ")
    result = calculate(
        num1, num2, {'1': '+', '2': '-', '3': '*', '4': '/'} .get(choice, ''))
    print("Result:", result)
    if choice == '5':
        print("Exiting the calculator")
        break
