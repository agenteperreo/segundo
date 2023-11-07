namespace Objetos
{
    public class clsUsuarios
    {
        #region Atributos
        String nombre;
        String nombreUsuario;
        String apellidos;
        String contrasena;
        #endregion

        #region Constructores
        public clsUsuarios()
        {
            nombre = "";
            nombreUsuario = "";
            apellidos = "";
            contrasena = "";
        }

        public clsUsuarios(string nombre, string nombreUsuario, string apellidos, string contraseña)
        {
            this.nombre = nombre;
            this.nombreUsuario = nombreUsuario;
            this.apellidos = apellidos;
            this.contrasena = contraseña;
        }
        #endregion

        #region Propiedades
        public String Nombre { get { return nombre; } set { nombre = value; } }
        public String NombreUsuario { get {  return nombreUsuario; } set { nombreUsuario = value; } }
        public String Apellidos { get {  return apellidos; } set {  apellidos = value; } }
        public string Contrasena { get {  return contrasena; } set {  contrasena = value; } }

        #endregion

    }
}