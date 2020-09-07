using System;


namespace Ejercicio2{

    class Persona{

        private string nombre;
        private int edad;
        private string sexo;

        public Persona(string nombre, int edad, string sexo){
            this.nombre = nombre;
            this.edad = edad;
            this.sexo = sexo;
        }
        
        public string getNombre(){return this.nombre;}
        public string getSexo(){return this.sexo;}
        public int getEdad(){return this.edad;}
        public void setNombre(string nombre){this.nombre = nombre;}
        public void setSexo(string sexo){this.sexo = sexo;}
        public void seteEdad(int edad){this.edad = edad;}
    }

}
