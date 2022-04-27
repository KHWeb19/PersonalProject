<template>
    <form @submit.prevent="onSubmit">
       <table>
           <div class="box">
          
            
             <tr>
               
                <td>
                    <input type="text"  v-model="title" class="form-control">
                </td>
                

                
            </tr>

            <tr>
                

            
            <tr>
                <td>
                     <input type="text"  v-model="writer" class="form-control" >
                   
                </td>
            </tr>

            <tr>
                <td>
               <v-file-input class="mx-10" v-model="files" @change="select" label="사진 찾기"
      color="secondary"  chips multiple ></v-file-input>

    <v-card class="mx-5" flat>
      <v-img class="ml-5" :src="url" width="50%"/>
    </v-card>
                </td>
            </tr>

            <tr>
               
                <td>
                    <textarea cols="100" rows="30" v-model="content" class="form-control">

                        
                    </textarea>
                </td>
            </tr>
                      <div>
 
   
  </div>
  
           </div>



      


        </table>

        

        <div>
            <button type="submit">등록</button>
            <router-link :to="{ name: 'JpaBoardListPage' }">
                취소
            </router-link>
        </div>
        
 
  

    
    </form>
    
    
</template>

<script>

export default {
    name: 'JpaBoardRegisterForm',
    data () {
        return {
            title: '제목을 작성하세요.',
            writer: '작성자를 작성하세요',
            content: '본문을 작성하세요.',
            image: '사진을 올려주세요',
             previewImage: null,
              files: [],
      url: null
        }
    },
    methods: {
        onSubmit () {
            const { title, writer, content, files } = this
            this.$emit('submit', { title, writer, content, files })
        },
      select () {
      console.log(this.files)
      try {
        this.url = URL.createObjectURL(this.files[0])
      }catch(e) {
        this.url = null
      }
      
      this.$emit('selectFile', this.files)
    },
    
  }
}

  
</script>

<style scoped>

  .box{
          background:white;
          
          border: #356859 4px solid;
        }
        
        .imagePreviewWrapper {
    width: 250px;
    height: 250px;
    display: block;
    cursor: pointer;
    margin: 0 auto 30px;
    background-size: cover;
    background-position: center center;
}

</style>

