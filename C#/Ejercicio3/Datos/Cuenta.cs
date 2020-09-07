using System;

namespace Ejercicio3
{
    class Cuenta
    {   
        private double saldo;
        private long numeroCuenta;
        private string nombre;
        public Cuenta(string nombre, long numeroCuenta){
            this.nombre = nombre;
            this.numeroCuenta = numeroCuenta;
            this.saldo = 0;
        }
        public double getSaldo()
        {
            return this.saldo;
        }

        public void setSaldo(double saldo)
        {
            this.saldo = saldo;
        }

        public long getnumeroCuenta()
        {
            return this.numeroCuenta;
        }

        public void setnumeroCuenta(long numeroCuenta)
        {
            this.numeroCuenta = numeroCuenta;
        }

        public string getNombre()
        {
            return this.nombre;
        }

        public void setNombre(string nombre)
        {
            this.nombre = nombre;
        }

        

    }



}