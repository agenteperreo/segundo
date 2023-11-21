namespace Biblioteca
{
    public class clsMision
    {
        #region Atributos
        private int id;
        private string nombreMision;
        private string descripcion;
        #endregion

        #region Constructores
        public clsMision() 
        { 
            id = 0;
            nombreMision = "";
            descripcion = "";
        }

        public clsMision(int id, string nombreMision, string descripcion)
        {
            this.id = id;
            this.nombreMision = nombreMision;
            this.descripcion = descripcion;
        }
        #endregion

        #region Propiedades
        public int Id
        {
            get { return id; }
            set { id = value; }
        }

        public string NombreMision 
        { 
            get {  return nombreMision; } 
            set {  nombreMision = value; } 
        }

        public string Descripcion 
        { 
            get {  return descripcion; } 
            set {  descripcion = value; } 
        }
        #endregion
    }
}