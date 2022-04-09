<template>
    <div>
        
             <h3 align="left"> 업로드할 이미지 : </h3>
             <v-file-input class="input" type="file" v-model="files"
             counter show-size label="이미지 제출(여러개 가능)"
             outlined dense multiple prepend-icon="mdi-camera"
              @change="onInputImage"/>
           
        
            <br>
        
    </div>
</template>

<script>


export default {
    name: 'UploadFile',
    data () {
        return {
            files: [],
        }
    },
    methods: {
       
        onInputImage () {
         // console.log(this.files) 반영 확인 완

           this.$emit('selectFile',this.files)
        }
    }
}

</script>