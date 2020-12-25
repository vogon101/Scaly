# print("ho ho ho")
# print("ho ho ho")
# print("ho ho ho")
# print("ho ho ho")
# print("ho ho ho")
print("ho ho ho")
print("ho ho ho")
#
#
# class Main:
#
#     def main():
#         if x:
#             y()
#         else:
#             z()
#         return 999
#
#     @property
#     def func2(self):
#         z= 100
#         print(x.y)
#         print(self)
#         return self.method
#
#     def foo(self, n):
#         return n
#
# # print(Main.main())
# x = Main()
# print(x.func2)

class Main:
    def main():
        FibGen().fib(5)
        return 100

class FibGen:
    def fib(self, n):
        if (n.__lt__(2)): return 1
        else: return self.fib(n.__sub__(1)).__add__(self.fib(n.__sub__(2)))