using System;

namespace Ejercicio2{
    class Logica{
        private Persona paciente;
        
        public Logica(Persona paciente){
            this.paciente = paciente;
        }

        public void setPaciente(Persona paciente){this.paciente = paciente;}
        public Persona getPaciente(){return this.paciente;}

        public float CalcularPulsaciones(){
            string sexo = this.paciente.getSexo();
            int edad = this.paciente.getEdad();

            float pulse = 0;
            if(sexo.Equals("F")){
                pulse = 220-edad;
                pulse /= 10;
            }
            else{
                pulse = 210-edad;
                pulse /= 10;
            }

            return pulse;

        }
    }
}
