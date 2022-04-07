<template>
     <div id="app">
    <v-container fluid>
      <v-divider></v-divider>
      <br>
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
    <v-row align="center" justify="center" >
       <v-btn width="400"
    class="blue lighten-5" 
    onclick="submit">검색</v-btn>
    </v-row>
    </v-container>
    <br>
    <v-divider></v-divider>
    

     
    
    <!--submit을 누르면 e7의 정보를 갖고 components/kategorie1List페이지로 이동-->


</div>
</template>
<script>
export default {
    name:'DropDown',
    data(){
        return{
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