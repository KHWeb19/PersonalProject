<template>
 <div>
 <v-btn
   추천버튼
          class="ma-2"
          text
          icon
          color="blue lighten-2"
        >
          <v-icon>mdi-thumb-up</v-icon>
        </v-btn>
  
        <v-btn 비추저튼
          class="ma-2"
          text
          icon
          color="red lighten-2"
        >
          <v-icon>mdi-thumb-down</v-icon>
        </v-btn>

   
        찜 버튼 아이콘
          <v-btn
        class="mx-2"
        fab
        dark
        small
        color="pink"
      >
        <v-icon dark>
          mdi-heart
        </v-icon>
      </v-btn>
       <v-dialog v-model="dialog" max-width="500">
          <template v-slot:activator="{ on }">
            <v-btn  v-on="on">점수 입력</v-btn>
          </template>
      <v-card >
        <v-card-title>
          <h2>점수를 입력하세요</h2>
        </v-card-title>
<br>
<br>
        <v-card-text>
          <v-row>
           <table class="table">
          <tr>
          <td><h4>자바:</h4></td>
        <td>
          <v-text-field
          type="number"
          v-model="java"
          ></v-text-field>
        </td>
         <td><h4>SQL:</h4></td>
        <td>
         <v-text-field
         type="number"
          v-model="sql"
         ></v-text-field>
        </td>
          </tr>
           </table>
          </v-row>
<br>
<br>


        <v-row align="center" justify="center">
           <v-btn @click="Calculate()" >
             계산하기
           </v-btn>
        </v-row>

<br>
<br>

          <v-row>
           <table class="table">
          <tr>
          <td><h4>총점:</h4></td>
        <td>
           <v-text-field
           :value="this.total"
           ></v-text-field>
        </td>
         <td><h4>평균:</h4></td>
        <td>
           <v-text-field
           :value="this.average"
           ></v-text-field>
        </td>
          </tr>
           </table>
          </v-row>

        </v-card-text>

        <signup></signup>
        
        <v-divider></v-divider>
        <v-card-actions>
          <v-btn @click="btnCancle()" class="secondary--text font-weight-bold" text>cancel</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  
 </div>
</template>

<script>
export default {
    data(){
        return{
          java:"",
          sql:"",
          total:"",
          average:"",
          dialog: false,
        }
    },
    methods:{
      btnCancle(){
 this.dialog=false
      },
      Calculate(){
        this.java=Number(this.java);
        this.sql=Number(this.sql)
        this.total=this.java+this.sql;
        this.average=(this.java+this.sql)/2

      }
    }
}

</script>