<%@ page contentType="text/html;charset=UTF-8" %>
<div id="loader-wrapper">
    <div id="loader"></div>
    <div class="loader-section section-left"></div>
    <div class="loader-section section-right"></div>
</div>

<div class="modal" id="loaderModal" style="width: 20%;top: 50%">

    <div class="modal-content">
        <h4>Loading</h4>
        <div class="row" style="text-align: center;margin-bottom: 10px">
            <div class="preloader-wrapper big active">
                <div class="spinner-layer spinner-blue">
                    <div class="circle-clipper left">
                        <div class="circle"></div>
                    </div>
                    <div class="gap-patch">
                        <div class="circle"></div>
                    </div>
                    <div class="circle-clipper right">
                        <div class="circle"></div>
                    </div>
                </div>

                <div class="spinner-layer spinner-red">
                    <div class="circle-clipper left">
                        <div class="circle"></div>
                    </div>
                    <div class="gap-patch">
                        <div class="circle"></div>
                    </div>
                    <div class="circle-clipper right">
                        <div class="circle"></div>
                    </div>
                </div>

                <div class="spinner-layer spinner-yellow">
                    <div class="circle-clipper left">
                        <div class="circle"></div>
                    </div>
                    <div class="gap-patch">
                        <div class="circle"></div>
                    </div>
                    <div class="circle-clipper right">
                        <div class="circle"></div>
                    </div>
                </div>

                <div class="spinner-layer spinner-green">
                    <div class="circle-clipper left">
                        <div class="circle"></div>
                    </div>
                    <div class="gap-patch">
                        <div class="circle"></div>
                    </div>
                    <div class="circle-clipper right">
                        <div class="circle"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div id="modalPop" class="modal">
    <div class="modal-content">
        <h4>请选择导入类型</h4>

        <div>
            url链接和图片上传二选其一

            <form id="uploadForm">

                <div class="input-field">
                    <input id="imageUrl" type="text" name="imageUrl"/>
                    <label for="imageUrl">请输入网络图片url</label>
                </div>

                <div class="file-field input-field">
                    <div class="btn">
                        <span>Upload File</span>
                        <input type="file" name="imageFile">
                    </div>
                    <div class="file-path-wrapper">
                        <input class="file-path validate" type="text">
                    </div>
                </div>

            </form>

        </div>

    </div>

    <div class="modal-footer">
        <a class="modal-action modal-close waves-effect waves-green btn-flat" onclick="bookApi()">Submit</a>
    </div>
</div>