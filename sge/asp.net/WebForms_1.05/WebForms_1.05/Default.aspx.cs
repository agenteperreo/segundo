using Microsoft.Ajax.Utilities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebForms_1._05
{
    public partial class _Default : Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void TextBox1_TextChanged(object sender, EventArgs e)
        {

        }

        protected void btnSaludar_Click(object sender, EventArgs e)
        {
            String name = txtNombre.Text;

            clsPersona persona = new clsPersona();

            if(String.IsNullOrEmpty(name)) {
                lblVacio.Text = "El nombre es nulo o vacio";
                lblSaludo.Text = "";
            } else { 
                lblSaludo.Text = "Hola "+name;
                lblVacio.Text = "";
            }
            
        }
    }
}