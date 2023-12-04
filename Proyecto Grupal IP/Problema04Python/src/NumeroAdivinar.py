import random

def play():
    num_adiv = random.randint(1, 100)
    intentos_falt = 10
    
    while intentos_falt > 0:
        intentos = int(input("Ingresa un numero del 1 al 100: "))
        pista = 0
        
        if intentos == num_adiv:
            print("¡Bien, has adivinado el numero!")
            break
        else:
            intentos_falt -= 1
            print(f"Te quedan {intentos_falt} intentos.\n")
            
            if intentos_falt > 0:
                pista_input = input("Tienes opción a una pista (si/no): ").lower()

                if pista_input == "si":
                    print("Ingresa el número de la pista que deseas:"
                          "\n1. Si quieres saber si el número es mayor o menor."
                          "\n2. Si quieres saber si el número es par o impar."
                          "\n3. Si quieres saber si el número es primo."
                          "\n4. Si quieres saber si el número es múltiplo de algún número.")
                    print("")
                    
                    pista = int(input())
                    
                    if pista == 1:
                        print(f"Te quedan {intentos_falt} intentos.")
                        if num_adiv < intentos:
                            print("- PISTA: Intenta con un numero menor")
                        else:
                            print("- PISTA: Intenta con un numero mayor")
                    elif pista == 2:
                        print(f"Te quedan {intentos_falt} intentos.")
                        if num_adiv % 2 == 0:
                            print("- PISTA: El numero es par")
                        else:
                            print("- PISTA: El numero es impar")
                    elif pista == 3:
                        print(f"El número de pista seleccionado es: {pista}")
                        if es_primo(num_adiv):
                            print("El numero es un número primo.")
                        else:
                            print("El numero no es un número primo.")
                    elif pista == 4:
                        print(f"El número de pista seleccionado es: {pista}")
                        div = int(input("Ingrese el posible divisor: "))

                        if es_multiplo(num_adiv, div):
                            print(f"{num_adiv} es múltiplo de {div}")
                        else:
                            print(f"No es múltiplo de {div}")
                    
                    intentos_falt -= 1
                    print(f"Te quedan: {intentos_falt} intentos\n")
            
    if intentos_falt == 0:
        print(f"Te has quedado sin intentos. El numero es: {num_adiv}")
    
    nuevo_intento = input("¿Quieres jugar de nuevo? (si/no): ").lower()
    
    if nuevo_intento == "si":
        play()

def es_multiplo(intento, div):
    return intento % div == 0

def es_primo(intento):
    if intento <= 1:
        return False
    for i in range(2, int(intento**0.5) + 1):
        if intento % i == 0:
            return False
    return True

if __name__ == "__main__":
    play()