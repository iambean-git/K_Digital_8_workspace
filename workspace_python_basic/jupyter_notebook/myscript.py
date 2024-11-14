#file myscript. py

def square(x) :
    """숫자 제곱"""
    return x**2

for N in range(1,4) :
    print(N, "의 제곱은", square(N))