// Ejemplo sencillo de tipos básicos en TypeScript

// Número: almacena valores numéricos
let numero: number = 42;

// Cadena: almacena texto
let cadena: string = "Hola TypeScript";

// Booleano: almacena valores verdadero o falso
let esVerdadero: boolean = true;

// Array: define un arreglo de números
let numeros: number[] = [1, 2, 3, 4, 5];

// Tupla: un arreglo de tamaño fijo con tipos específicos en cada posición
let tupla: [string, number] = ["Juan", 30];

// Enum: define un conjunto de constantes nombradas
enum Color {
  Rojo,
  Verde,
  Azul
}

let colorFavorito: Color = Color.Verde;

// Any: permite asignar cualquier tipo de valor
let cualquierCosa: any = "puede ser cualquier cosa";
cualquierCosa = 10;

// Void: especifica que una función no retorna ningún valor
function saludar(): void {
  console.log("¡Hola!");
}

// Null y Undefined: valores especiales
let nada: null = null;
let indefinido: undefined = undefined;

// Imprimir en consola los valores de las variables
console.log("Número:", numero);
console.log("Cadena:", cadena);
console.log("Booleano:", esVerdadero);
console.log("Array:", numeros);
console.log("Tupla:", tupla);
console.log("Color favorito:", colorFavorito);
console.log("Any:", cualquierCosa);

saludar();