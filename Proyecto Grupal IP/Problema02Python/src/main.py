import random

class SistemaUTPL:
    def __init__(self, name, ci):
        self.ape = random.uniform(6.5, 10.0)
        self.adc = random.uniform(6.5, 10.0)
        self.aa = random.uniform(0, 3)
        self.name = name
        self.ci = ci

    def porcentaje_aprueba(self):
        porcentaje_final = (self.ape + self.adc + self.aa) / 3
        return porcentaje_final * 10

    def aprueba(self):
        return self.porcentaje_aprueba() >= 70

class Asignatura:
    def __init__(self, name):
        self.name = name

if __name__ == "__main__":
    print("Ingresar la Cantidad de Estudiantes")
    num_est = int(input())
    
    estudiantes = []

    pasa = 0
    no_pasa = 0
    calif_exam = random.uniform(0, 10)

    for i in range(num_est):
        name = f"Estudiante -> {i + 1}"
        ci = str(random.randint(0, 1000000000))

        estudiante = SistemaUTPL(name, ci)

        print(f"Estudiante N#: {estudiante.name}")
        print(f"Cedula de Identidad: {estudiante.ci}")
        print(f"Calificacion APE: {estudiante.ape}")
        print(f"Calificacion ADC: {estudiante.adc}")
        print(f"Calificacion AA: {estudiante.aa}")

        calif = (estudiante.ape * 0.35) + (estudiante.adc * 0.35) + (estudiante.aa * 0.3)
        print(f"LA CALIFICACION TOTAL ES: {calif}")

        if estudiante.aprueba():
            print("Aprobado ")
            pasa += 1
        else:
            print("Debe rendir examen de recuperacion")
            calif_recupera = (calif_exam * 0.35) + (calif * 0.6)
            print(f"Calificacion del Examen de Recuperacion {calif_exam}")

            if calif_recupera < 7:
                print("HAS REPROBADO")
                print(f"CALIFICACION: {calif}")
                no_pasa += 1
            else:
                print("HAS APROBADO :)")
                pasa += 1

        estudiantes.append(estudiante)

    print("\nESTADISTICAS")
    print("Estadistica de Estudiantes Aprobados y Reprobados ")
    print(f"Han Aprobado: {pasa}")
    print(f"Han Reprobado: {no_pasa}")
    print(f"Porcentaje de Estudiantes Aprobados: {(pasa / num_est) * 100}%")
    print(f"Porcentaje de Estudiantes Reprobados: {(no_pasa / num_est) * 100}%")
