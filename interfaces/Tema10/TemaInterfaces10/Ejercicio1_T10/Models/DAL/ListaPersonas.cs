using Ejercicio1_T10.Models.Entidades;

namespace Ejercicio1_T10.Models.DAL
{
    public static class ListaPersonas
    {
        /// <summary>
        /// Funcion que devuelve un listado de personas
        /// Precondicion: Ninguna
        /// Postcondicion: Ninguna
        /// </summary>
        /// <returns>Listado de personas</returns>
        public static List<clsPersona> listadoCompletoPersonas()
        { 
            List<clsPersona> listadoPersonas = new List<clsPersona>();

            listadoPersonas.Add(new clsPersona(1, "Pedro", "Cornejo", "987654321", 1));
            listadoPersonas.Add(new clsPersona(2, "Isa Katha", "Loetzer", "486217935", 2));
            listadoPersonas.Add(new clsPersona(3, "Paco", "Calvo", "159753684", 3));

            return listadoPersonas;
        }

    }
}
