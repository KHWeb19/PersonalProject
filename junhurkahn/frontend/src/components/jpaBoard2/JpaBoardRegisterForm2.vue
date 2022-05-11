<template>
    <form @submit.prevent="onSubmit">
        <table>
           <div class="box">
            <tr>
              
                <td>
                   <input type="text"  v-model="content" class="form-control" >
                </td>
            </tr>

               <tr>
                <td>
                     <div class="imagePreviewWrapper" :style="{ 'background-image': `url(${previewImage})` }" > </div>
                      <input ref="fileInput" type="file" @input="pickFile">
                </td>
            </tr>

            <tr>
               
                <td>
                    <textarea cols="100" rows="30" v-model="title" class="form-control">
                    </textarea>
                </td>
            </tr>
           </div>
        </table>

        <div>
            <button type="submit">등록</button>
            <router-link :to="{ name: 'JpaBoardListPage2' }">
                취소
            </router-link>
        </div>
    </form>
</template>

<script>
export default {
    name: 'JpaBoardRegisterForm2',
    data () {
        return {
            title: '물건목록을 작성하세요.',
            content: '본문을 작성하세요.',
             previewImage: null
        }
    },
    methods: {
        onSubmit () {
            const { title, content } = this
            this.$emit('submit', { title,  content })
        },
    

          selectImage () {
          this.$refs.fileInput.click()
      },
        pickFile () {
        let input = this.$refs.fileInput
        let file = input.files
        if (file && file[0]) {
          let reader = new FileReader
          reader.onload = e => {
            this.previewImage = e.target.result
          }
          reader.readAsDataURL(file[0])
          this.$emit('input', file[0])
        }
      }
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