<template>
    <div>
        
             <br>
            <h3 align="left"> 업로드할 파일 : </h3>
              <div>
                <label>Files
                  <v-file-input class="input" type="file" counter show-size label="이미지 제출(여러개 가능)"
              outlined dense multiple prepend-icon="mdi-camera" style="width: 400px; margin-left: 100px;"
              @change="onImageChange"/>
                </label>
                <button v-on:click="submitFiles()">파일 업로드</button>
            </div>
            <br>
        
    </div>
</template>

<script>

//import axios from 'axios'

export default {
    name: 'UploadFile',
    data () {
        return {
            uploadimageurl: [],	// 업로드한 이미지의 미리보기 기능을 위해 url 저장하는 객체
            imagecnt: 0,	
        }
    },
    methods: {
        onImageChange(file) {	// v-file-input 변경시
      if (!file) {
        return;
      }
      
      const formData = new FormData();	// 파일을 전송할때는 FormData 형식으로 전송
      this.uploadimageurl = [];		// uploadimageurl은 미리보기용으로 사용
      file.forEach((item) => {
        formData.append('filelist', item)
        console.log(item)	// formData의 key: 'filelist', value: 이미지
        const reader = new FileReader();
        reader.onload = (e) => {
          this.uploadimageurl.push({url: e.target.result});
          // e.target.result를 통해 이미지 url을 가져와서 uploadimageurl에 저장
        };
        reader.readAsDataURL(item);
      });
     
    },
    }
}
</script>