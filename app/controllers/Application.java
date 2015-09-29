package controllers;

import play.*;
import play.mvc.*;

import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;

import views.html.*;

import java.io.File;

public class Application extends Controller {

    /** トップページ */
    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    /** ファイルのアップロード処理 */
    public static Result upload() {
        MultipartFormData body = request().body().asMultipartFormData();
        FilePart picture = body.getFile("picture");
	if (picture != null) {
            String fileName = picture.getFilename();
            String contentType = picture.getContentType();
            File file = picture.getFile();
            if ( contentType.equals("image/jpeg") ) {
                String fullPath = Play.application().path().getPath() + "/public/images/";
                file.renameTo(new File(fullPath, fileName));
	    }
	return ok("ふぁいる、上がったで。");
        }else{
            flash("error", "Missing file");
	    return redirect(routes.Application.index());
        }
    }
}
