<template>
  <div class="container">
    <div class="row">
      <div class="col-sm-4 col-md-6 col-lg-7">
        <section
          enctype="multipart/form-data"
          @submit.prevent="onSubmit"
          class="product-section product-review"
          id="product-review"
          role="tabpanel"
        >
          <header class="product-section-header">
            <h1 class="title">리뷰</h1>
          </header>

          <form>
            <div
              v-for="commenList in paginatedData"
              :key="commenList.commentNo"
              class="product-section-content"
            >
              <ol class="review-list">
                <li
                  class="review-item"
                  style="border-bottom: 1px solid #e0e2e7"
                >
                  <article class="review-card">
                    <header class="review-card-header">
                      <h3 class="visually-hidden">
                        {{ commenList.writer }}님이 작성한 리뷰
                      </h3>

                      <div class="info">
                        <a class="username" href="/">
                          <strong>{{ commenList.writer }}</strong>
                        </a>

                        <div class="detail">
                          <div
                            class="star-rating-13"
                            aria-label="5.0점 / 5.0점"
                          >
                            <i class="ic-star is-active"></i>
                            <i class="ic-star is-active"></i>
                            <i class="ic-star is-active"></i>
                            <i class="ic-star"></i>
                            <i class="ic-star"></i>
                          </div>
                          <div class="misc">
                            {{ commenList.regDate }}
                          </div>
                        </div>
                      </div>
                    </header>
                    <div class="review-card-body">
                      <div
                        class="review-image"
                        v-if="commenList.fileName != null"
                      >
                        <img
                          :src="
                            require(`@/assets/image/${commenList.fileName}`)
                          "
                          alt="리뷰사진"
                        />
                      </div>
                      <p>
                        {{ commenList.comment }}
                      </p>
                    </div>

                    <footer class="review-card-footer">
                      <button
                        @click="onLike"
                        class="btn-black btn-42"
                        type="button"
                      >
                        <i class="ic-check" aria-hidden></i>
                        도움됨
                      </button>
                      <p>
                        <strong><span></span>1명</strong>에게 도움이 되었습니다.
                      </p>
                    </footer>
                    <button
                      @click="onDelete(commenList.commentNo)"
                      class="delete-button"
                      type="button"
                      aria-label="해당 리뷰 삭제하기"
                    >
                      <i class="ic-close" aria-hidden></i>
                    </button>
                  </article>
                </li>
              </ol>
            </div>
            <div class="pagination">
              <button
                @click="prevPage"
                class="page-control page-prev"
                type="button"
              >
                <i class="ic-chevron"></i>
              </button>
              <ol class="page-list">
                <li
                  class="page-item"
                  v-for="n in pageCount"
                  :key="n"
                  @click="setPage(n - 1)"
                  :class="{ isactive: n == pageNum + 1 }"
                >
                  <a>
                    {{ n }}
                  </a>
                </li>
              </ol>
              <button
                @click="nextPage"
                class="page-control page-next"
                type="button"
              >
                <i class="ic-chevron"></i>
              </button>
            </div>
          </form>
          <div class="review-modal">
            <div class="review-modal-title">별점 평가</div>
            <div class="review-modal-star">
              <div class="review-modal-star-label">만족도</div>
              <div class="rating-input">
                <input id="rate5" type="radio" name="rating" />
                <label for="rate5" class="rating-input-star">
                  <i class="ic-star"></i>
                </label>

                <input id="rate4" type="radio" name="rating" />
                <label for="rate4" class="rating-input-star">
                  <i class="ic-star"></i>
                </label>

                <input id="rate3" type="radio" name="rating" />
                <label for="rate3" class="rating-input-star">
                  <i class="ic-star"></i>
                </label>

                <input id="rate2" type="radio" name="rating" />
                <label for="rate2" class="rating-input-star">
                  <i class="ic-star"></i>
                </label>

                <input id="rate1" type="radio" name="rating" />
                <label for="rate1" class="rating-input-star">
                  <i class="ic-star"></i>
                </label>
              </div>
            </div>
          </div>

          <div class="review-file">
            <div class="review-card-content header">사진 첨부(선택)</div>

            <div class="review-card-btn">
              <div class="select-picture" v-if="image">
                <img
                  class="select-picture-contents"
                  :src="image"
                  alt="첨부한 사진"
                />
                <button
                  @click="imageDelete"
                  class="delete-button"
                  type="button"
                  aria-label="첨부 파일 삭제하기"
                >
                  <i class="ic-close" aria-hidden></i>
                </button>
              </div>
              <input
                class="visually-hidden"
                id="files"
                type="file"
                ref="files"
                multiple
                v-if="uploadReady"
                v-on:change="commentFileUpload()"
              />
              <button
                class="btn-black btn-46"
                type="button"
                @click="onUpload"
                aria-label="사진 첨부하기"
              >
                사진 첨부하기
              </button>
            </div>
          </div>

          <form class="review-form">
            <div class="review-card-content">
              <div class="review-card-content header">리뷰 작성</div>
              <textarea
                v-model="comment"
                style="border-radius: 4px"
                class="form-control"
                minlength="20"
                maxlength="1000"
                cols="120"
                rows="32"
                placeholder="자세하고 솔직한 리뷰는 다른 고객에게 큰 도움이 됩니다.(최소 20자 이상)"
              ></textarea>
            </div>
            <div class="review-card-btn">
              <button class="btn-black btn-46" type="submit">완료</button>
            </div>
          </form>
        </section>
      </div>
    </div>
  </div>
</template>
<script>
import axios from "axios"
export default {
  name: "ProductComment",
  props: {
    productComments: {
      type: Array,
    },
    listArray: {
      type: Array,
      required: true,
    },
    pageSize: {
      type: Number,
      required: false,
      default: 3,
    },
  },
  data() {
    return {
      userInfo: this.$store.state.userInfo,
      uploadReady: true,
      commentNo: "",
      comment: "",
      fileName: "",
      regDate: "",
      image: "",
      writer: "",
      files: [],
      id: "",
      pageNum: 0,
    }
  },
  created() {
    this.writer = this.$store.state.userInfo.id
  },
  methods: {
    imageDelete() {
      this.image = null

      this.clearImage()
    },
    clearImage() {
      this.uploadReady = false
      this.$nextTick(() => {
        this.uploadReady = true
      })
    },
    onUpload() {
      this.$refs.files.click()
    },
    onDelete(commentNo) {
      console.log(commentNo)
      axios
        .delete(`http://localhost:8888/product/comment/delete/${commentNo}`, {
          commentNo,
        })
        .then(() => {
          alert("삭제 성공!")
          history.go(0)
        })
        .catch(() => {
          alert("삭제 실패")
        })
    },
    onSubmit() {
      const { comment, writer } = this
      const file = this.$refs.files.files[0]
      this.$emit("submit", { comment, writer, file })
      console.log(comment, writer, file)
    },
    onLike() {
      if (this.userInfo != null) {
        const { commentNo, id } = this
        axios
          .post(`http://localhost:8888/product/like/${commentNo}`, { id })
          .then((res) => {
            if (res.data) {
              alert("좋아요 성공")
              this.$router.go()
            } else {
              alert("이미 좋아요를 누르셨습니다.")
            }
          })
          .catch(() => {
            alert("오류 발생")
          })
      } else {
        alert("로그인 후 이용해주세요.")
      }
    },
    commentFileUpload() {
      var image = this.$refs["files"].files[0]
      this.image = URL.createObjectURL(image)
      this.files = this.$refs.files.files[0]
    },

    nextPage() {
      if (this.pageNum === this.pageCount - 1) {
        this.pageNum = this.pageCount - 1
      } else {
        this.pageNum += 1
      }
    },

    prevPage() {
      if (this.pageNum === 0) {
        this.pageNum = 0
      } else {
        this.pageNum -= 1
      }
    },

    setPage(v) {
      this.pageNum = v
    },
  },

  computed: {
    pageCount() {
      let listLeng = this.listArray.length
      let listSize = this.pageSize
      let page = Math.floor(listLeng / listSize)
      if (listLeng % listSize > 0) page += 1

      return page
    },

    paginatedData() {
      const start = this.pageNum * this.pageSize

      const end = start + this.pageSize

      return this.listArray.slice(start, end)
    },
  },
}
</script>
<style lang="scss" scoped>
@import "~@/assets/scss/components/review-card";
@import "~@/assets/scss/modules/select-picture";
</style>
