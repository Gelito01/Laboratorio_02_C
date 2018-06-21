package xshadows.laboratorio_02_c;

import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public  class  MyAdapter extends BaseAdapter {

    //ATRIBUTOS
    //cONTEXTO DONDE VA A SER CARGADO EL ADAPTADOR
    private Context context;
    //LAYOUT LE VAMOS A DAR LA REFERENCIA
    private int layout;
    //LISTA DE STRING DE NOMBRES
    private List<String> names;

    //CONSTRUIMOS EL ADAPTADOR: DONDE SE LE PASA LOS DATOS A SER RELLENADO
    public MyAdapter(Context context,int layout,List<String> names){
        this.context=context;
        this.layout=layout;
        this.names=names;
    }

    @Override
    //PASAMOS LA LISTA DE NOMBRES A DIBUJAR
    public int getCount() {
        return this.names.size();
    }

    @Override
    //revuelve de el array la posiscion
    public Object getItem(int position) {
        return this.names.get(position);
    }

    @Override
    //devuelve el id
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        // MEJORA DE RENDIMIENTO

        ViewHolder holder;

        if (convertView == null){
            // INFLAMOS LA VISTA QUE NOS HA LLEGADO CON NUESTRO LAYOUT PERSONALIZADO
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(R.layout.list_item,null);

            holder  = new ViewHolder();
            //REFERENCIAMOS EL ELEMENTO A MODIFICAR Y LO RELLENAMOS
            holder.nameTextView=(TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        //Nos traemos el valor actual dependiente de la posicion
        String currentName=names.get(position);

        //REFERENCIAMOS EL ELEMENTO A MODIFICAR Y LO LLENAMOS
        holder.nameTextView.setText(currentName);

        // DEVOLVEMOS LA VISTA INFLADA Y MODIFICADA CON NUESTROS DATOS
        return convertView;
    }

    static class ViewHolder {
        private TextView nameTextView;

    }
}
