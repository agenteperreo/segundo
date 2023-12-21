namespace Entidades
{
    public class clsMarcas
    {
        #region Atributos
        private int id;
        private string nombre;
        #endregion

        #region Constructor
        public clsMarcas()
        {

        }
        public clsMarcas(int id, string nombre)
        {
            this.id = id;
            this.nombre = nombre;
        }
        #endregion

        #region Propiedades
        public int Id
        {
            get { return id; }
            set { id = value; }
        }

        public string Nombre
        {
            get { return nombre; }
            set { nombre = value; }
        }
        #endregion
    }
}