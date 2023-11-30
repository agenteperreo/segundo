namespace Entidades
{
    public class clsMarcas
    {
        #region Propiedades
        public int IdMarca { get; set; }
        public string Nombre { get; set; }
        #endregion

        #region Constructores
        public clsMarcas() { }

        public clsMarcas(int idMarca, string nombre)
        {
            IdMarca = idMarca;
            Nombre = nombre;
        }
        #endregion
    }
}
