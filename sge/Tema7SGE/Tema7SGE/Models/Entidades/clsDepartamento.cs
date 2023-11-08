namespace Tema7SGE.Models.Entidades
{
    public class clsDepartamento
    {

        #region Propiedades
        public int idDept { get; set; }
        public String nomDept { get; set; }
        #endregion

        #region Constructores
        public clsDepartamento()
        {
            idDept = 0;
            nomDept = "";
        }

        public clsDepartamento(int idDept, String nomDept)
        {
            this.idDept = idDept; 
            this.nomDept = nomDept;
        }
        #endregion
    }
}
