#include<iostream>
#include<cstdio>

using namespace std;

struct nodo{
	long doc;
	string nombre, apellido;
	int dias;
	double sueldo;
	nodo *siguiente;
	nodo *anterior;
	float diaTrabajo;
};

nodo *cabeza, *ultimo;


//Logica
void imprimirNodo(nodo*);
void llenar(nodo*);
nodo* diligenciar(long, string, string, float);
void mostrar();
nodo* buscar(long);

//Interfaz
int menuPrincipal();
bool opciones(int);
void agregarEmpleado();
int main(){
	do{}while(opciones(menuPrincipal()));
}

//funciones logicas del programa

nodo* diligenciar(long doc, string nombre, string apellido, float diaTrjo){
	nodo *p = new nodo();
	p->doc = doc;
	p->nombre = nombre;
	p->apellido = apellido;
	p->diaTrabajo = diaTrjo;

	return p;
}

void llenar(nodo *p){
	if(cabeza == NULL){
		cabeza = p;
	}
	else{
		p->anterior = ultimo;
		ultimo->siguiente = p;
	}
	ultimo = p;
	cout << "Agregado" << endl;
}


void imprimirNodo(nodo *p){
	if(p != NULL){
		cout << "Documento: " << p->doc << endl <<
			"Nombre: " << p->nombre << endl <<
			"Apellido: " << p->apellido << endl <<
			"Dias de trabajo: " << p->dias << endl <<
			"Valor por dia: " << p->diaTrabajo << endl <<
			"Sueldo: " << p->sueldo << endl;
	}
	else{
		cout << "No hay informacion" << endl;
	}
}

nodo* buscar(long doc){
	nodo *p = cabeza;
	while(p != NULL && p->doc != doc){
		p = p->siguiente;
	}

	return p;
}

void mostrar(){
	nodo *p = cabeza;
	while(p != NULL){
		imprimirNodo(p);
		p = p->siguiente;
	}
}

//interfaz del programa

int menuPrincipal(){
	system("clear");
	cout << ".:OPCIONES:." << endl <<
		"Agregar Empleado ...... (1)" << endl <<
		"Buscar Empleado ....... (2)" << endl <<
		"Mostrar Todos ......... (3)" << endl <<
		"Ver masa salarial ..... (4)" << endl << endl <<
			"Salir ................. (0)" << endl << endl <<
		"Seleccione: ";
	int c = 0;
	cin >> c;
	return c;
}

bool opciones (int c){
	bool tr = true;
	switch(c){
		case 0:{
			tr = false;
			break;
		       }
		case 1:{
			agregarEmpleado();
			break;
		       }
	} 

	return tr;
}


void agregarEmpleado(){
	long doc = 0;
	string nombre = "", apellido = "";
	float dia = 0;

	cout << "#Datos del Empleado#" << endl;
	fflush(stdin);
	cout <<	"Documento: ";
	cin >> doc;
	cout <<	"Nombre: ";
	fflush(stdin);
	getline(cin, nombre);
	cout <<	"Apellido: ";
	getline(cin, apellido);
	cout <<	"Valor de dia de trabajo: ";
	cin >> dia;

	llenar(diligenciar(doc, nombre, apellido, dia));
}

