using Biblioteca;

namespace ElMandaloriano.Models.DAL
{
    public class obtenerMision
    {

        /// <summary>
        /// Metodo que devuelve una mision en función del id pasado por parametros
        /// Precondición: El id debe ser mayor que 0
        /// Postcondiciones: El objeto devuelto puede ser null o una misión rellena si se encuentra.
        /// </summary>
        /// <param name="Id">int</param>
        /// <returns>Devuelve una mision con el id pasado por parametros</returns>
        public static clsMision obtenerMisionId(int Id, List<clsMision> listaMisiones)
        {
            listaMisiones = clsListaMisiones.getListaCompletaMisiones();
            return listaMisiones.Find(x => x.Id == Id);
        }
    }
}
