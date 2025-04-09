// Función simple que recibe dos números y retorna su suma
function sumar(a: number, b: number): number {
    return a + b;
  }
  
  // Función que recibe un nombre y muestra un saludo en consola
  // La función no retorna ningún valor, por ello se define el tipo de retorno como void
  function saludar(nombre: string): void {
    console.log(`¡Hola, ${nombre}!`);
  }
  
  // Función anónima asignada a una constante utilizando arrow function (función flecha)
  // Se definen los tipos de los parámetros y el tipo de retorno como number
  const multiplicar = (a: number, b: number): number => a * b;
  
  // Función que utiliza parámetros opcionales
  // El parámetro "nombre" es opcional y se indica con el signo "?".
  // Dependiendo de si se recibe o no un argumento, retorna un saludo personalizado o un saludo genérico.
  function obtenerSaludo(nombre?: string): string {
    if (nombre) {
      return `Hola, ${nombre}!`;
    } else {
      return "Hola!";
    }
  }
  
  // Ejemplos de uso de las funciones definidas
  
  // Se imprime el resultado de la suma
  console.log("Suma:", sumar(3, 4)); // Imprime: Suma: 7
  
  // Se llama a la función saludar con un nombre como argumento
  saludar("Carlos"); // Imprime: ¡Hola, Carlos!
  
  // Se imprime el resultado de la multiplicación
  console.log("Multiplicación:", multiplicar(2, 5)); // Imprime: Multiplicación: 10
  
  // Uso de la función con parámetro opcional para obtener un saludo
  console.log(obtenerSaludo("Ana")); // Imprime: Hola, Ana!
  console.log(obtenerSaludo());      // Imprime: Hola!