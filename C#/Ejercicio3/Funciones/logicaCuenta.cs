using System;


namespace Ejercicio3
{
    class logicaCuenta
    {
        private Cuenta cuentaUsuario;


        public Cuenta getCuentaUsuario()
        {
            return this.cuentaUsuario;
        }

        public void setCuentaUsuario(Cuenta cuentaUsuario)
        {
            this.cuentaUsuario = cuentaUsuario;
        }
        public logicaCuenta(Cuenta cuentaUsuario){
            this.cuentaUsuario = cuentaUsuario;
        }
        public void consignarSaldo(){
            Console.Write("\nSaldo: ");
            double saldo = double.Parse(Console.ReadLine());
            saldo += cuentaUsuario.getSaldo();
            cuentaUsuario.setSaldo(saldo);
            Console.WriteLine("\nSaldo agregado...");
     
        }

        public void retirarSaldo(){
            Console.Write("\nSaldo: ");
            double saldo = double.Parse(Console.ReadLine());
            if(cuentaUsuario.getSaldo() > saldo){
                saldo *= -1;
                saldo += cuentaUsuario.getSaldo();
                cuentaUsuario.setSaldo(saldo);
                Console.WriteLine("\nSaldo retirado...");
            }
            else{
                saldo = 0;
                Console.WriteLine("\nNo es posible retirar, saldo insuficiente...");
            }
           
        }
    }
}