<template>
     <div id="app">
  <v-app id="inspire">
    <v-container fluid>
      <v-row align="center">
       
  
        <v-col
          cols="12"
          sm="6"
        >
          <v-subheader v-text="'select the Brand What you want to check'"></v-subheader>
        </v-col>
  
        <v-col
          cols="12"
          sm="6"
        >
          <v-select
            v-model="e7"
            :items="states"
            label="Select"
            multiple
            chips
            hint="What are the target Brand"
            persistent-hint
          ></v-select>
        </v-col>
      </v-row>
    </v-container>
    
    <v-btn class="blue lighten-5" onclick="submit">검색</v-btn>
  </v-app>
</div>
</template>
<script>
export default {
    name:'DropDown',
    data(){
        return{
       e6: [],
       e7: [],
      states: [
        'HEMES', 'VITTON', 'CHANEL', 'GUCCI',
        'FENDI', 'PRADA', 'Dior', 'VANCLEE',
        'Tiffany', 'Cartier', 'bottega',
        'YSL', 'Supreme', 'BURBERRY', 'THOM', 'BALENCIAGA',
        'ROLEX', 'IWC', 'PIAGET', 'OMEGA', 'TAG',
      ],
    }
  },
}
</script>