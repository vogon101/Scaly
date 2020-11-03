import sys, py_compile
if __name__ == "__main__":
    if (len(sys.argv) != 3):
        print("Usage compile <source> <target>")
    else:
        py_compile.compile(sys.argv[1], sys.argv[2])
