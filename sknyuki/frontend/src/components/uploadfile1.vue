<template>
    <div>
        
             <h3 align="left"> 업로드할 이미지 : </h3>
             <v-file-input class="input" type="file" v-model="files"
             counter show-size label="이미지 제출"
             outlined dense multiple prepend-icon="mdi-camera"
              @change="onInputImage"/>
           <v-card class="mx-10" flat>
      <v-img class="ml-10" :src="url" width="100%"/>
             </v-card>
        
            <br>
        
    </div>
</template>

<script>


export default {
    name: 'UploadFile1',
    data () {
        return {
            files: [],
          
        }
    },
    methods: {
       
        onInputImage () {
         // console.log(this.files) 반영 확인 완
             try {
        this.url = URL.createObjectURL(this.files[0])
      }catch(e) {
        this.url = null
      }
           this.$emit('selectFile',this.files)
        }
    }
}

</script>