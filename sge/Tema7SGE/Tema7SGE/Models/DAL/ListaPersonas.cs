using Microsoft.AspNetCore.Mvc;
using Tema7SGE.Models.Entidades;

namespace Tema7SGE.Models.DAL
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

            listadoPersonas.Add(new clsPersona("Pedro", "Cornejo", "987654321"));
            listadoPersonas.Add(new clsPersona("Isa Katha", "Loetzer", "486217935"));
            listadoPersonas.Add(new clsPersona("Paco", "Calvo", "159753684"));

            return listadoPersonas;
        }

    }
}
