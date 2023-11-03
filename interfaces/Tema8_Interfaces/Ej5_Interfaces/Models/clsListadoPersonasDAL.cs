using LibreriaEntidades;
using System.Collections.ObjectModel;

namespace Ej5_Interfaces.Models
{
    public static class clsListadoPersonasDAL
    {

        /// <summary>
        /// Función que devvuelve un observable collection con personas
        /// </summary>
        /// <returns>Listado de personas del observable collection</returns>
        public static ObservableCollection<clsPersona> listadoPersonas()
        {
            ObservableCollection<clsPersona> listadoPersonas = new ObservableCollection<clsPersona>()
            {
                new clsPersona("Manuel","Perez"),
                new clsPersona("Juanma","Caballero"),
                new clsPersona("Isa K","Loetzer"),
                new clsPersona("Alvaro","Castro"),
                new clsPersona("Fresco","Lobato"),
                new clsPersona("Paco","Calvo"),
                new clsPersona("Manuel","Tirado"),
                new clsPersona("Manuel","Tirado")
            };

            return listadoPersonas;
        }
    }
}
