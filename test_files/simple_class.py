# print("ho ho ho")
# print("ho ho ho")
# print("ho ho ho")
# print("ho ho ho")
# print("ho ho ho")
print("ho ho ho")
print("ho ho ho")


class Main:
    def main():
        FibGen().fib(5)
        return 100

class FibGen:
    def __init__(self):
        self.thing = 100

    def fib(self, n):
        if (n.__lt__(2)): return 1
        else: return self.fib(n.__sub__(1)).__add__(self.fib(n.__sub__(2)))

    def foo():
        x = 10
        print(x)