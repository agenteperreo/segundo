namespace Biblioteca
{
    public class clsMision
    {
        #region Atributos
        private int id;
        private string nombreMision;
        private string descripcion;
        private string recompensa;
        #endregion

        #region Constructores
        public clsMision() 
        { 
            id = 0;
            nombreMision = "";
            descripcion = "";
            recompensa = "";
        }

        public clsMision(int id, string nombreMision, string descripcion, string recompensa)
        {
            this.id = id;
            this.nombreMision = nombreMision;
            this.descripcion = descripcion;
            this.recompensa = recompensa;
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

        public String Recompensa
        {
            get { return recompensa; }
            set { recompensa = value; }
        }
        #endregion
    }
}