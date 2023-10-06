namespace Biblioteca_comun
{
    public class clsPersona
    {

        #region Atributos
        private String nombre;
        private String apellidos;
        #endregion

        #region Constructores
        public clsPersona()
        {
            nombre = "";
            apellidos = "";
        }

        public clsPersona(String nombre, string apellidos)
        {
            this.nombre = nombre;
            this.apellidos = apellidos;
        }
        #endregion

        #region Propiedades
        public String Nombre
        {
            get { return nombre; }
            set { nombre = value; }
        }

        public String Apellidos { 
            get { return apellidos; } 
            set { apellidos = value; } 
        }
        #endregion

    }
}