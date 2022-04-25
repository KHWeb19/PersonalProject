<template>
<form @submit.prevent="onSubmit">
   <div class="app">
            <h3 style="padding:30px 0px 30px 0px; font-weight:bold" align="center">게시글 작성</h3>
  <v-sheet class="mt-5 mb-10">
    <v-row>
      <v-col cols="12" md="8">
        <upload-file-1 @selectFile="selectFile"></upload-file-1>
      </v-col>
      <v-col cols="12" md="4">
      
        <v-card align="center" class="mt-5 pa-2">
          <h3>상세 목록</h3>
           <table >
            <tr>
                <td><h4>브랜드:</h4></td>
                <td>
                    <v-select
            :items="states"
            label="Brand Type"
            dense
            style="width:300px; font-size:15px;"
             v-model="type"
          ></v-select>
                </td>
            </tr>
             <tr>
                <td><h4>등급:</h4></td>
                <td>
                     <v-select
            :items="RankSelect"
            label="Brand Rank"
            dense
            style="width:300px; font-size:15px;"
             v-model="rank"
          ></v-select>
                </td>
            </tr>
            <tr>
                <td><h4>제품명:</h4></td>
                <td>
                    <input type="text" v-model="Name"/>
                </td>
            </tr>
            <tr>
                <td><h4>사이즈:</h4></td>
                <td>
                     <input type="text" v-model="size"/>
                </td>
            </tr>
            <tr>
                <td><h4>가격:</h4></td>
                <td>
                     <input type="text" v-model="price"/>
                </td>
            </tr>
            <tr>
                <td><h4>부속품:</h4></td>
                <td>
                     <input type="text" v-model="accessories"/>
                </td>
            </tr>
           
             <tr>
                <td><h4>세부상태:</h4></td>
                <td>
                    <textarea cols="50" rows="10" v-model="status">
                    </textarea>
                </td>
            </tr>


        </table>

         <div class="버튼">
           <v-row>
             <v-col>
                <v-btn text color="black" rounded x-large
                    style="padding: 10px; width: 30px;" type="submit" >등록하기
                </v-btn>
             </v-col>
                <br>
              <v-col>
                <router-link style="text-decoration: none; color:black" :to="{ name: 'K2ProductView' }">
                    <v-btn text color="black" rounded x-large
                        style="padding: 10px; width: 30px;" type="submit">목록으로
                    </v-btn>
                </router-link>
              </v-col>
           </v-row>
            </div>
        </v-card>
        <rank-description/>
      </v-col>
    </v-row>
  </v-sheet>
   </div>
</form>
</template>

<script>
import UploadFile1 from '@/components/uploadfile1.vue'
import RankDescription from '@/components/RankDescription.vue'

export default {
    name:'ProductBoardRegister',
    components:{
       UploadFile1,
      RankDescription, 
    },
     data () {
        return {
            type: '',
            name: '',
            size: '',
            price: '',
            rank: '',
            accessories: '',
            status: '',
            files:[],
            states: [
        'HEMES', 'VITTON', 'CHANEL', 'GUCCI',
        'FENDI', 'PRADA', 'Dior', 'VANCLEE',
        'Tiffany', 'Cartier', 'bottega',
        'YSL', 'Supreme', 'BURBERRY', 'THOM', 'BALENCIAGA',
        'ROLEX', 'IWC', 'PIAGET', 'OMEGA', 'TAG','Others'
      ],
      RankSelect:[
        'SA','A','AB','B','BC','C'
      ]
        }
    },
      methods: {
        selectFile(files){
            this.files=files
        },
         onSubmit () {
            var result = confirm('등록 하시겠습니까?')
            if(result) {
                const { type, name, size, price, rank, accessories, status} = this
                this.$emit('submitContents', { type, name, size, price, rank, accessories, status})
                console.log(this.type,this.name,this.size ,this.price)

                this.$emit("submitFiles",this.files)
                console.log(this.files)
            }
         }
      }
}
</script>