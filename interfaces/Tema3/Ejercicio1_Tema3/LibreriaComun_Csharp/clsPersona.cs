namespace LibreriaComun_Csharp
{
    public class clsPersona
    {

        #region Atributos
        private String nombre;
        #endregion

        #region Constructores
        public clsPersona()
        {
            nombre = "";
        }

        public clsPersona(String nombre) 
        {
            this.nombre = nombre;
        }
        #endregion

        #region Propiedades
        public String Nombre { get { return nombre; } set { nombre = value; } }
        #endregion
    }
}