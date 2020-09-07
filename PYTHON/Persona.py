class Persona:
    nombre = ""
    apellido = ""
    cedula = 0
    telefono = 0

    def __init__(self, nombre, apellido, cedula, telefono):
        self.nombre = nombre
        self.apellido = apellido
        self.cedula = cedula
        self.telefono = telefono

    def mostrar(self):
        print("nombre: {}\napellido: {}\ncedula: {}\ntelefono: {}\n".format(self.nombre,self.apellido,self.cedula,self.telefono))


